package com.example.esjumbo

import androidx.lifecycle.ViewModel
import com.example.esjumbo.data.FormState
import com.example.esjumbo.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

private const val HARGA_PER_CUP = 3000
class OrderViewModel : ViewModel() {
    private val _stateUi = MutableStateFlow(OrderUIState())
    private val _nameSTATE = MutableStateFlow(FormState())
    val stateUI:StateFlow<OrderUIState> = _stateUi.asStateFlow()
    val nameST : StateFlow<FormState> = _nameSTATE.asStateFlow()

    fun setNama(list: MutableList<String>){
        _nameSTATE.update { stateSaatIni -> stateSaatIni.copy(
            nama = list[0],
            alamat = list[1],
            phone = list[2]
        ) }
    }
    fun setJumlah(jmlEsJumbo:Int){
        _stateUi.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)
            )
        }
    }
    fun setRasa(rasaPilihan: String){
        _stateUi.update { stateSaatIni ->
            stateSaatIni.copy(rasa = rasaPilihan)
        }
    }
    fun resetOrder(){
        _stateUi.value = OrderUIState()
    }
    private fun hitungHarga(
        jumlah: Int =_stateUi.value.jumlah,
    ): String{
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }
}