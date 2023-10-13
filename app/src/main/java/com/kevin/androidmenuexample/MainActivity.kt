package com.kevin.androidmenuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.kevin.androidmenuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding for Activity Main
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)

        // Set up PopupMenu
        setUpPopupMenu()

        //  Set up ContextMenu
        setUpContextMenu()
    }

    private fun setUpContextMenu() {
        // Register the view to show the context menu
        registerForContextMenu(binding.btnShowContextMenu)
    }

    // Create the context menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        // Inflate the context menu
        menuInflater.inflate(R.menu.options_menu, menu)

    }

    // set up the popup menu
    private fun setUpPopupMenu() {
        binding.btnShowPopupMenu.setOnClickListener {
            val popupMenu = androidx.appcompat.widget.PopupMenu(this, it)
            popupMenu.inflate(R.menu.options_menu)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_settings -> {
                        toast("Settings")
                        true
                    }

                    R.id.action_share -> {
                        toast("Share")
                        true
                    }

                    R.id.action_notification -> {
                        toast("Notification")
                        true
                    }

                    else -> false
                }
            }
            popupMenu.show()
        }
    }


    // Create the toast function
    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Create the options menu

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    // Handle the menu item click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> {
                toast("Settings")
                true
            }

            R.id.action_share -> {
                toast("Share")
                true
            }

            R.id.action_notification -> {
                toast("Notification")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }


    // Handle the context menu item click

    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> {
                toast("Settings")
                true
            }

            R.id.action_share -> {
                toast("Share")
                true
            }

            R.id.action_notification -> {
                toast("Notification")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

}