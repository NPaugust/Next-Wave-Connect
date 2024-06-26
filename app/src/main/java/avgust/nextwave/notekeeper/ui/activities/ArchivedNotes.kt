package avgust.nextwave.notekeeper.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import avgust.nextwave.notekeeper.R
import avgust.nextwave.notekeeper.adapter.NotesListAdapter
import avgust.nextwave.notekeeper.databinding.ActivityArchivedNotesBinding
import avgust.nextwave.notekeeper.ui.fragments.home.NotesViewModel
import avgust.nextwave.notekeeper.utils.Resource

@AndroidEntryPoint
class ArchivedNotes : AppCompatActivity() {
    private lateinit var binding: ActivityArchivedNotesBinding
    private val viewModel : NotesViewModel by viewModels()
    private val adapter : NotesListAdapter by lazy {
        NotesListAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArchivedNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.archivedNotesToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.archived_notes)

        binding.archivedNotesRecyclerView.adapter = adapter

        this.lifecycleScope.launchWhenCreated {
            viewModel.getArchivedNotes()
        }
        viewModel.note.observe(this){ state ->
            when (state){
                is Resource.Loading -> {
                    binding.archivedNotesProgressBar.isVisible = true
                }
                is Resource.Success -> {
                    binding.archivedNotesProgressBar.isVisible = false
                    adapter.submitList(state.data)
                }
                is Resource.Error -> {
                    binding.archivedNotesProgressBar.isVisible = false
                    Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}