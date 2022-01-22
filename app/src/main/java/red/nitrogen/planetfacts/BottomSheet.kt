package red.nitrogen.planetfacts

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottomsheet.*
import java.lang.RuntimeException

class BottomSheet: BottomSheetDialogFragment(), View.OnClickListener {
    private var mListener:ItemClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet,container,false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is ItemClickListener){
            context
        }else {
            throw RuntimeException(
                context.toString()+"Must implement ItemClickListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        overview_text.setOnClickListener(this)
        internal_text.setOnClickListener(this)
        geology_text.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val selected = p0 as TextView
        mListener!!.onItemClick(selected.text.toString())
        dismiss()
    }
}