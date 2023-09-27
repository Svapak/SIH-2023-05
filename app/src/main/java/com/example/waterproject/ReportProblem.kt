package com.example.waterproject

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class ReportProblem : AppCompatActivity(){

//    var types = arrayOf<String?>("C", "Data structures",
//        "Interview prep", "Algorithms",
//        "DSA with java", "OS")
    private lateinit var imgUri: Uri
    private val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()){

        if (it != null) {
            imgUri = it
        }
        val ImgView : ImageView = findViewById(R.id.selectImage)
        ImgView.setImageURI(it)
        ImgView.layoutParams.height = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_problem)

        val problemTypes = arrayOf(
            "Urban Flooding",
            "Rural Flooding",
            "Oil Spill",
            "Tsunami",
            "Polluted River",
            "Drought",
            "Drainage problems"
        )

        val dropDownMenu : Button = findViewById(R.id.problemType)
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

}