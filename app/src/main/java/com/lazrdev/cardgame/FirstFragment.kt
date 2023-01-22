package com.lazrdev.cardgame

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.lazrdev.cardgame.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.naslov)
        val angle= 45
        val shader =
            textView?.let { LinearGradient(0f, 0f, 0f, it.textSize, Color.parseColor("#324E7E"), Color.parseColor("#9A4696"), Shader.TileMode.CLAMP) }
        if (textView != null) {
            textView.paint.shader = shader
        }
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    view.findViewById<Button>(R.id.domace_zivotinje).setOnClickListener(){
        val intent = Intent(context, DomaceZivotinje::class.java)
        startActivity(intent)
    }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}