package com.example.practicam08uf1.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.practicam08uf1.R
import com.example.practicam08uf1.databinding.FragmentListBinding
import com.example.practicam08uf1.models.ListAdapter
import com.example.practicam08uf1.models.Seminario
import com.example.practicam08uf1.models.SeminarioViewModel
import com.example.practicam08uf1.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment(), ListAdapter.OnSeminarioClickListener {
    private lateinit var binding: FragmentListBinding
    private lateinit var mSeminarioViewModel: SeminarioViewModel
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var listaSeminarios: List<Seminario>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_list, container, false)
        binding = FragmentListBinding.bind(view)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = ListAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = recyclerView.adapter as ListAdapter
        mSeminarioViewModel = ViewModelProvider(this).get(SeminarioViewModel::class.java)

        mSeminarioViewModel.readAllData.observe(viewLifecycleOwner, Observer { seminario ->
            adapter.setData(seminario)
        })

        refreshLayout = binding.swipeRefreshLayout
        refreshLayout.setOnRefreshListener {
            getAllSeminarios()
            refreshLayout.isRefreshing = false
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllSeminarios()
    }

    fun getAllSeminarios() {
        val apiClient = ApiClient()
        val seminariosResponse: Call<List<Seminario>> = apiClient.getInterface()
            .getSeminarios("http://www.xtec.cat/~jmendez1/forteco/courses.json")
        seminariosResponse.enqueue(object : Callback<List<Seminario>> {
            override fun onResponse(
                call: Call<List<Seminario>>,
                response: Response<List<Seminario>>
            ) {
                if (response.code() == 200) {
                    Log.d("Buscaminas", response.body().toString())
                    listaSeminarios = response.body()!!
                    insertDataToDatabase(listaSeminarios)
                } else {
                    Log.d("Buscaminas", "no funciona")
                }
            }

            override fun onFailure(call: Call<List<Seminario>>, t: Throwable) {
                Log.d("Buscaminas", "error" + t.localizedMessage)
            }
        })
    }

    fun insertDataToDatabase(listadoSeminarios: List<Seminario>?) {
        for (seminario in listadoSeminarios.orEmpty()) {
            mSeminarioViewModel.addSeminario(seminario)
        }
    }

    override fun onSeminarioClick(position: Int) {
        val action = ListFragmentDirections.actionListFragmentToItemFragment(listaSeminarios.get(position))
        findNavController().navigate(action)
    }
}