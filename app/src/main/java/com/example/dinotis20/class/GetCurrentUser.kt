package com.example.dinotis20.`class`

import android.util.Log
import com.example.dinotis20.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GetCurrentUser {
    private lateinit var currentUser: FirebaseAuth
    private val docRef = Firebase.firestore

    public fun getCurrentUser(): User {
        currentUser = Firebase.auth

        var user = arrayListOf<User>()
        docRef.collection("Users").document(currentUser.uid.toString())
            .get()
            .addOnSuccessListener { doc ->
                if (doc != null) {
                    user.add(User(doc.get("email").toString(), doc.get("name").toString()))
                } else {
                    user.add(User("uh oh", "my bad"))
                    Log.d("", "Document not found!")
                }
            }
            .addOnFailureListener { e ->
                Log.w("", "Error fetching document: "+e)
            }

        return user[0]
    }
}