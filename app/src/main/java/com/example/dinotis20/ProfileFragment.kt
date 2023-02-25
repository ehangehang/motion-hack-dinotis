package com.example.dinotis20

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val currentUser = Firebase.auth
    private val docRef = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        docRef.collection("Users").document(currentUser.uid.toString())
            .get()
            .addOnSuccessListener { doc ->
                if (doc != null) {
                    profile_txt_name?.text = doc.get("name").toString()
                    profile_txt_roles?.text = doc.get("roles").toString()
                } else {
                    Log.d("", "Document not found!")
                }
            }
            .addOnFailureListener { e ->
                Log.w("", "Error fetching document: "+e)
            }

        frag_profile_account?.setOnClickListener {
            startActivity(Intent(view.context, EditProfileActivity::class.java))
        }

        frag_profile_subs?.setOnClickListener {
            startActivity(Intent(view.context, ChosenCreatorActivity::class.java))
        }

        frag_profile_portfolio?.setOnClickListener {
            startActivity(Intent(view.context, PortfolioActivity::class.java))
        }

        frag_profile_roles?.setOnClickListener {
            startActivity(Intent(view.context, PickRoleActivity::class.java))
        }

        frag_profile_help?.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=6281392413876"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        frag_profile_logout?.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Logout")
            builder.setMessage("Are you sure you want to logout?")
            builder.setPositiveButton("Yes") { dialog, which ->
                Firebase.auth.signOut()
                startActivity(Intent(view.context, LoginActivity::class.java))
            }
            builder.setNegativeButton("No") { dialog, which ->
                Toast.makeText(view.context, "Cancelled logout", Toast.LENGTH_SHORT).show()
            }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}