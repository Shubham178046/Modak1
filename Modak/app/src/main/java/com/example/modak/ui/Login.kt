package com.example.modak.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.modak.R
import com.example.modak.header.SessionManagement
import com.example.modak.header.User
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*


const val RC_SIGN_IN=123
class Login : AppCompatActivity() {

//   var textInputLayout :TextInputLayout= findViewById(R.id.textinput)
//   var textInputLayout1 :TextInputLayout =findViewById(R.id.textinput1)

    var callbackManager: CallbackManager? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // hide status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
// Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        /// facebook code
        //FacebookSdk.sdkInitialize(applicationContext)
        //AppEventsLogger.activateApp(applicationContext)

        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        val signup: TextView = findViewById(R.id.txt_Signup)
        var button: Button = findViewById(R.id.login_btn)

        btn_google.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val personName = acct.displayName
            val personGivenName = acct.givenName
            val personFamilyName = acct.familyName
            val personEmail = acct.email
            val personId = acct.id
            val personPhoto: Uri? = acct.photoUrl

            Toast.makeText(applicationContext, acct.displayName, Toast.LENGTH_LONG).show()
        }
        signup.setOnClickListener {
            startActivity(Intent(applicationContext, Register::class.java))

        }

        button.setOnClickListener {
            confirm()
        }
        val btn_Facebook: Button = findViewById(R.id.btn_facebook)
        callbackManager = CallbackManager.Factory.create()
        btn_Facebook.setOnClickListener {
            LoginManager.getInstance()
                .logInWithReadPermissions(this, Arrays.asList("email", "public_profile"))
            LoginManager.getInstance()
                .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult?) {
                        //Log.d("Login", "onSuccess: "+ result?.accessToken?.token)
                        moveToMainActivity()
                    }

                    override fun onCancel() {
                        Log.d("Login", "Facebook OnCancel")
                    }

                    override fun onError(error: FacebookException?) {
                        Log.d("Login", "Facebook Error : " + error.toString())
                    }

                })

            /*val accessToken = AccessToken.getCurrentAccessToken()
            val isLoggedIn = accessToken != null && !accessToken.isExpired*/
        }
    }

    protected override fun onStart() {
        super.onStart()
        checkSession()
    }

    private fun checkSession() {
        var context: Context = applicationContext
        var sessionManagement: SessionManagement = SessionManagement(context)
        var user_Id: Int = sessionManagement.getSession()

        if (user_Id != -1) {
            moveToMainActivity()
        } else {

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account =
                completedTask.getResult(ApiException::class.java)
            updateSignIn(account!!)
        } catch (e: ApiException) {
            Log.d("Error", "handleSignInResult: " + e.toString())
        }
    }

    private fun updateSignIn(account : GoogleSignInAccount) {
        Log.d("Google User", "updateSignIn: "+account.displayName+" "+ account.id)

        moveToMainActivity()
    }

    private fun confirm() {

        if (edtemail.text.toString().isEmpty()) {
            edtemail.error = "Email Should Not Be Blank"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edtemail.text.toString().trim()).matches()) {
            edtemail.error = "Invalid Email Id"
        } else if (edtpassword.text.toString().isEmpty()) {
            edtpassword.error = "Password Should Not Be Blank"
        } else {

            //startActivity(Intent(applicationContext,Home_Navigation::class.java))
            login()
            Toast.makeText(applicationContext, "Login Sucessfull", Toast.LENGTH_LONG).show()
        }

    }

    override fun onBackPressed() {
        // Intent intent = new Intent(Intent.ACTION_MAIN);
        val intent: Intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME);
        // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public fun login() {
        var context: Context = applicationContext
        val user: User = User(12, "Shubham")
        val sessionManagement: SessionManagement = SessionManagement(context)
        sessionManagement.saveSession(user)
        moveToMainActivity()
    }

    private fun moveToMainActivity() {
        callFacebookLogout(applicationContext)
        val intent: Intent = Intent(applicationContext, Home_Navigation::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    public fun callFacebookLogout(context: Context) {
       /* if (AccessToken.getCurrentAccessToken() != null) {

            GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/permission/",
                null,
                HttpMethod.DELETE,
                GraphRequest.Callback {
                    AccessToken.setCurrentAccessToken(null)
                    LoginManager.getInstance().logOut()
                }).executeAsync()
        }*/


        if (AccessToken.getCurrentAccessToken() == null) {
            Log.d("Facebook", "callFacebookLogout: "+" "+ "Already Logged Out")
            return  // already logged out
        }

        GraphRequest(
            AccessToken.getCurrentAccessToken(),
            "/me/permissions/",
            null,
            HttpMethod.DELETE,
            object : GraphRequest.Callback {
                override fun onCompleted(graphResponse: GraphResponse?) {
                    LoginManager.getInstance().logOut()
                }
            }).executeAsync()
    }
}
