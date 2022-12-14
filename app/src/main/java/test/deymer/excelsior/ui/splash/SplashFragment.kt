package test.deymer.excelsior.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import test.deymer.excelsior.databinding.FragmentSplashBinding
import test.deymer.excelsior.utils.setOnSingleClickListener

class SplashFragment: Fragment() {

    private val binding: FragmentSplashBinding by lazy {
        FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        initClickListener()
    }

    private fun initClickListener() {
        binding.buttonStart.setOnSingleClickListener {
            val action = SplashFragmentDirections.actionSplashFragmentToSearchFragment()
            findNavController().navigate(action)
        }
    }
}