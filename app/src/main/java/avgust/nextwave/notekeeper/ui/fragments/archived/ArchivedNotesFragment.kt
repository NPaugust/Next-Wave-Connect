package avgust.nextwave.notekeeper.ui.fragments.archived

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import avgust.nextwave.notekeeper.R
import avgust.nextwave.notekeeper.databinding.FragmentArchivedNotesBinding

@AndroidEntryPoint
class ArchivedNotesFragment : Fragment() {
    private lateinit var binding: FragmentArchivedNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_archived_notes, container, false)
    }
}