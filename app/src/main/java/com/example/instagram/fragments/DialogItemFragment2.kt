package com.example.instagram.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DialogItemFragment2:BottomSheetDialogFragment() {
    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.dialog2,container)
        return root
    }
}