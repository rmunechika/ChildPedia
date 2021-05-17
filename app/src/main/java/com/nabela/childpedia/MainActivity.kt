package com.nabela.childpedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.nabela.childpedia.create.CreateActivity
import com.nabela.childpedia.databinding.ActivityMainBinding
import com.nabela.childpedia.user.UserProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val profilFragment = UserProfileFragment()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option,menu)
     return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeFragment)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(homeFragment)
                R.id.nav_create -> {
                    val intent = Intent(this, CreateActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_profil -> replaceFragment(profilFragment)
            }
            true
        }

    }
    private fun replaceFragment(fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }
}