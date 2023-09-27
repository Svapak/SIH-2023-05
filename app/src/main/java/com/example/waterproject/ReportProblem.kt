package com.example.waterproject

import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.waterproject.ml.ModelUnquant
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class ReportProblem : AppCompatActivity(){

//    var types = arrayOf<String?>("C", "Data structures",
//        "Interview prep", "Algorithms",
//        "DSA with java", "OS")
    private lateinit var imgUri: Uri
    private lateinit var bitmap : Bitmap
    private lateinit var tvOutput : TextView
    private val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()){

        if (it != null) {
            imgUri = it
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgUri)

        }
        val ImgView : ImageView = findViewById(R.id.selectImage)
        ImgView.setImageURI(it)
        outputGenerator(bitmap)
        ImgView.layoutParams.height = 200

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_problem)

//        val problemTypes = arrayOf(
//            "Urban Flooding",
//            "Rural Flooding",
//            "Oil Spill",
//            "Tsunami",
//            "Polluted River",
//            "Drought",
//            "Drainage problems"
//        )

        val dropDownMenu : Button = findViewById(R.id.problemType)
        val tvOutput : TextView = findViewById(R.id.tvType)
        var checkedItemId : Int = 0
        var problemType : String = "none"
        dropDownMenu.setOnClickListener {
            val popupMenu= PopupMenu(applicationContext,dropDownMenu)
            popupMenu.menuInflater.inflate(R.menu.problem_types_menu,popupMenu.menu)
            if (checkedItemId!=0)
                popupMenu.menu.findItem(checkedItemId).isChecked=true

            popupMenu.setOnMenuItemClickListener {item ->
                item.isChecked = true
                checkedItemId=item.itemId
                problemType=item.title.toString()
                dropDownMenu.text = problemType

                true
            }
            popupMenu.show()
        }

        val insertImage : ImageView = findViewById(R.id.selectImage)
        insertImage.setOnClickListener{
            selectImage.launch("image/*")
        }


//        val titleTV: TextView :




    }
    private fun outputGenerator(bitmap: Bitmap) {



        val model = ModelUnquant.newInstance(this)

        var imageProcessor = ImageProcessor.Builder()
            .add(ResizeOp(224,224, ResizeOp.ResizeMethod.BILINEAR)).build()

        var tensorImage = TensorImage(DataType.FLOAT32)
        tensorImage.load(bitmap)
        tensorImage =imageProcessor.process(tensorImage)


        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)


        inputFeature0.loadBuffer(tensorImage.buffer)


        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        val confidences: FloatArray = outputFeature0.floatArray

        var maxPos = 0
        var maxConfidence = 0f
        for (i in confidences.indices) {
            if (confidences[i] > maxConfidence) {
                maxConfidence = confidences[i]
                maxPos = i
            }
        }

        val classes = arrayOf("Urban Flooding", "Rural Flooding", "Oil Spill", "Tsunami", "Polluted River", "Drought", "Drainage Problem")
       tvOutput.text = classes[maxPos]
//        var s = ""
//        for (i in classes.indices) {
//            s += "${classes[i]}: ${String.format("%.1f%%", confidences[i] * 100)}\n"
//        }
//        tvOutput.text = s
// Releases model resources if no longer used.
        model.close()

    }

}