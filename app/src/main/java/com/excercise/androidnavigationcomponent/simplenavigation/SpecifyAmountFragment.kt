package com.excercise.androidnavigationcomponent.simplenavigation


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.excercise.androidnavigationcomponent.R
import kotlinx.android.synthetic.main.fragment_choose_recipient.cancel_btn
import kotlinx.android.synthetic.main.fragment_specify_amount.*

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.send_btn -> {
                //navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
                val amount = if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    input_amount.text.toString().toInt()
                } else {
                    0
                }
                val action = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(amount)
                navController?.navigate(action)
            }
            R.id.cancel_btn -> {
                activity!!.onBackPressed()
            }
        }
    }
}
