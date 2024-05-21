package avgust.nextwave.notekeeper.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import avgust.nextwave.notekeeper.adapter.ViewPagerAdapter
import avgust.nextwave.notekeeper.databinding.ActivityViewPagerBinding
import avgust.nextwave.notekeeper.onboarding.OnBoardingScreenOne
import avgust.nextwave.notekeeper.onboarding.OnBoardingScreenThree
import avgust.nextwave.notekeeper.onboarding.OnBoardingScreenTwo

@AndroidEntryPoint
class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = arrayListOf(
            OnBoardingScreenOne(),
            OnBoardingScreenTwo(),
            OnBoardingScreenThree()
        )

        val adapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

        binding.buttonGetStarted.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
            onBoardingFinished()
        }
    }

    private fun onBoardingFinished() {
        val sharedPreferences = this.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("onBoardingFinished", true)
        editor.apply()
    }
}