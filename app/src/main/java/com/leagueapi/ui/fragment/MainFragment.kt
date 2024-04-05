package com.leagueapi.ui.fragment

import android.health.connect.AggregateRecordsGroupedByDurationResponse
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.leagueapi.data.ChampionsService
import com.leagueapi.databinding.FragmentMainBinding
import com.leagueapi.model.Champion
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var screenWidth: Int = 0
    private var xdp: Float = 0f
    private lateinit var binding: FragmentMainBinding
    private var champions = ArrayList<Champion>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            screenWidth = it.getInt(ARG_PARAM1)
            xdp = it.getFloat(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)

        /*if(xdp >= 600)
            (binding.recycler.layoutManager as GridLayoutManager).spanCount = 3*/

        lifecycleScope.launch{
            ChampionsService.getChampions().collect{
                it.data.forEach { k, c ->
                    champions.add(c)
                }
                champions.sortBy{it.name}
                binding.recycler.adapter = ChampionsAdapter(champions, screenWidth!!)
            }
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: Float) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putFloat(ARG_PARAM2, param2)
                }
            }
    }
}