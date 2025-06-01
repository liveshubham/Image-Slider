package com.app.imageslider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.app.imageslider.databinding.FragmentBlankBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentBlankBinding
    private val sampleData = listOf(
        Products("Sneakers", "$59.99", listOf("https://images.unsplash.com/photo-1593642634367-d91a135587b5",
            "https://images.unsplash.com/photo-1593642634367-d91a135587b5",
            "https://images.unsplash.com/photo-1593642634367-d91a135587b5",
            "https://images.unsplash.com/photo-1593642634367-d91a135587b5",
            "https://images.unsplash.com/photo-1593642634367-d91a135587b5",
            "https://images.unsplash.com/photo-1593642634367-d91a135587b5",
            "https://images.unsplash.com/photo-1593642634367-d91a135587b5")),
        Products("Backpack", "$89.99", listOf("https://images.unsplash.com/photo-1518770660439-4636190af475",
            "https://images.unsplash.com/photo-1518770660439-4636190af475",
            "https://images.unsplash.com/photo-1518770660439-4636190af475",
            "https://images.unsplash.com/photo-1518770660439-4636190af475",
            "https://images.unsplash.com/photo-1518770660439-4636190af475",
            "https://images.unsplash.com/photo-1518770660439-4636190af475")),
        Products("Watch1", "$129.99", listOf("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d",
            "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d",
            "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d",
            "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d",
            "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d")),
        Products("Watch2", "$129.99", listOf("https://images.unsplash.com/photo-1498050108023-c5249f4df085",
            "https://images.unsplash.com/photo-1498050108023-c5249f4df085")),
        Products("Watch3","$78.45", listOf("https://images.unsplash.com/photo-1522071820081-009f0129c71c"))
    )
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
        binding=FragmentBlankBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewProducts.layoutManager=GridLayoutManager(requireContext(),2)
        binding.recyclerViewProducts.adapter=ProductAdapter(sampleData)
    }
}