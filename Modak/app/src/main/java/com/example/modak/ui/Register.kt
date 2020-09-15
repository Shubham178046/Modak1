package com.example.modak.ui

        import android.content.Intent
                import androidx.appcompat.app.AppCompatActivity
                import android.os.Bundle
                import android.util.Patterns
                import android.view.WindowManager
                import android.widget.Button
                import android.widget.EditText
                import android.widget.Toast
                import com.example.modak.R
                import kotlinx.android.synthetic.main.activity_register.*
                import java.util.regex.Pattern

        class Register : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_register)

                window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                var createaccount:Button=findViewById(R.id.create_account)

        createaccount.setOnClickListener {
            validate()
        }
    }

    private fun validate() {
       var firstname:EditText=findViewById(R.id.edt_firstname)
        var lastname:EditText=findViewById(R.id.edt_lastname)
        var email:EditText=findViewById(R.id.edt_email)
        var areacode:EditText=findViewById(R.id.edt_areacode)
        var cellno:EditText=findViewById(R.id.edt_cellcode)
        var blockno:EditText=findViewById(R.id.edt_blockno)
        var streetname:EditText=findViewById(R.id.edt_street)
        var apartment:EditText=findViewById(R.id.edt_apartment)
        var city:EditText=findViewById(R.id.edt_city)
        var zipcode:EditText=findViewById(R.id.edt_zipcode)

       // var emailpattern : String="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if(firstname.text.toString().isEmpty())
        {
            firstname.error="Firstname Should Not Be Blank"
        }
        else if(lastname.text.toString().isEmpty())
        {
            lastname.error="Lastname Should Not Be Blank"
        }
        else if(email.text.toString().isEmpty())
        {
            email.error="Email Should Not Be Blank"
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString().trim()).matches())
        {
            email.error="Invalid Email Id"
        }
        else if(areacode.text.toString().isEmpty())
        {
            areacode.error="Area Code Should Not Be Blank"
        }
        else if(cellno.text.toString().isEmpty())
        {
            cellno.error="Cell No Should Not Be Blank"
        }
        else if(!(cellno.length().equals(10)))
        {
            edt_cellcode.error="Invalid Phone No"
        }
        else if(blockno.text.toString().isEmpty())
        {
            blockno.error="Block No Should Not Be Blank"
        }
        else if(streetname.text.toString().isEmpty())
        {
            streetname.error="Street name Should Not Be Blank"
        }
        else if(apartment.text.toString().isEmpty())
        {
            apartment.error="Apartment Should Not Be Blank"
        }
        else if(city.text.toString().isEmpty())
        {
            city.error="City Should Not Be Blank"
        }
        else if(zipcode.text.toString().isEmpty())
        {
            zipcode.error="Zipcode Should Not Be Blank"
        }
        else if(checkbox.isChecked().equals(false))
        {
            Toast.makeText(applicationContext,"Select Terms and Condition",Toast.LENGTH_LONG).show()
        }
        else
        {
            startActivity(Intent(applicationContext,Home_Navigation::class.java))
        }
    }
//    private fun checkEmail(email:String) : Boolean
//    {
//        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
//    }
}
