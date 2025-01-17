package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback

class FragmentA : Fragment(R.layout.fragment_a) {

    private lateinit var openChildFragmentAABtn: Button
    private lateinit var nameOfFragmentTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (childFragmentManager.backStackEntryCount > 0) {
                        childFragmentManager.popBackStack()
                    } else {
                        parentFragmentManager.popBackStack()
                    }
                }
            })

        openChildFragmentAABtn = view.findViewById(R.id.openChildFragmentAABtn)
        nameOfFragmentTextView = view.findViewById(R.id.nameOfFragmentATextView)

        openChildFragmentAABtn.text = getString(R.string.open_fragment, "AA")
        nameOfFragmentTextView.text = getString(R.string.name_of_fragment, "A")

        val randomColor = ColorGenerator.generateColor()

        openChildFragmentAABtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(
                    R.id.childFragmentAAContainer,
                    FragmentAA.create(randomColor)
                )
                .addToBackStack(null)
                .commit()
        }
    }
}