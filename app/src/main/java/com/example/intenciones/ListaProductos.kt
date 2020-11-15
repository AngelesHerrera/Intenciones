package com.example.intenciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_products.*

class ListaProductos : AppCompatActivity(), IClickListenerProducto {
    val datos: ArrayList<Producto> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_productos)
        datosFalsos()
        var recycler: RecyclerView = findViewById(R.id.listaproductos)
        recycler.setHasFixedSize(true)
        val adaptador = Adaptador(this, datos, this)
        recycler.adapter= adaptador
    }
    fun datosFalsos(){
        datos.add(Producto("Producto1","$55"))
        datos.add(Producto("Producto2", "$100"))
        datos.add(Producto("Producto3", "$80"))
        datos.add(Producto("Producto4", "$150"))
        datos.add(Producto("Producto5", "$200"))
        datos.add(Producto("Producto6", "$120"))
    }

    override fun onCellClickListener(producto: Producto) {
        Log.e("Producto","Se presiono a: ${producto.nombreProducto}")
        Toast.makeText(this@ListaProductos,"seleccionaste ${producto.nombreProducto}",Toast.LENGTH_LONG).show()
    }
    }