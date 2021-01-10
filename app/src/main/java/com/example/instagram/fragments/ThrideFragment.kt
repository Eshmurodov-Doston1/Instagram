package com.example.instagram.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_thride.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [ThrideFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThrideFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }
    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root= inflater.inflate(R.layout.fragment_thride, container, false)
        root.clouce_btn_end.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commit()
            fragmentManager?.popBackStack()
        }
        Picasso.get().load(param1).into(root.img_instagram)
       Picasso.get().load("https://yt3.ggpht.com/ytc/AAUvwnhJadO7VnYGM3CXDmtPsK90RkfLNwnzcoFx__SqQQ=s900-c-k-c0x00ffffff-no-rj").into( root.image_pdpex)
       return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThrideFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ThrideFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}