package com.example.variosservicos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btHtml: Button
    private lateinit var btDiscar: Button
    private lateinit var btLigar: Button
    private lateinit var btEmail: Button
    private lateinit var btSms: Button
    private lateinit var btCompartilha: Button
    private lateinit var btPonto: Button
    private lateinit var btRota: Button
    private lateinit var btYoutube: Button
    private lateinit var btFoto: Button
    private lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHtml = findViewById(R.id.btHtml)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btLigar = findViewById(R.id.btLigar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btSms = findViewById(R.id.btSms)
        this.btCompartilha = findViewById(R.id.btCompartilhar)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btYoutube = findViewById(R.id.btYoutube)
        this.btFoto = findViewById(R.id.btFoto)
        this.ivFoto = findViewById(R.id.ivFoto)

        this.btHtml.setOnClickListener{
            val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }
        this.btDiscar.setOnClickListener{
            val uri = Uri.parse("tel:36121392")
            val it = Intent(Intent.ACTION_DIAL, uri)
            startActivity(it)
        }
        this.btLigar.setOnClickListener{
            val uri = Uri.parse("tel:36121392")
            val it = Intent(Intent.ACTION_CALL, uri)
            val call = Manifest.permission.CALL_PHONE
            val granted = PackageManager.PERMISSION_GRANTED
            if (ContextCompat.checkSelfPermission(this, call) == granted){
                startActivity(it)
            }
        }
        this.btEmail.setOnClickListener{
            val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")
            val it = Intent(Intent.ACTION_SENDTO, uri)
            it.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
            it.putExtra(Intent.EXTRA_TEXT, "Texto")
            startActivity(it)
        }
        this.btSms.setOnClickListener{
            val uri = Uri.parse("sms:36121392")
            val it = Intent(Intent.ACTION_SENDTO, uri)
            it.putExtra("sms_body", "Mensagem")
            startActivity(it)
        }
        this.btCompartilha.setOnClickListener{
            val it = Intent(Intent.ACTION_SEND)
            it.setType("text/plain")
            it.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar")
//it.setPackage("com.whatsapp")
            startActivity(Intent.createChooser(it, "Compartilhar"))
        }
        this.btPonto.setOnClickListener{
            val uri = Uri.parse("geo:-7.1356496,-34.8760932")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }
        this.btRota.setOnClickListener{
            val origem = "-7.1356496,-34.8760932"
            val destino = "-7.1181836,-34.8730402"
            val url = "http://maps.google.com/maps"
            val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }
        this.btYoutube.setOnClickListener{
            val uri = Uri.parse("vnd.youtube://H0Z7ewOXCKw")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }
        this.btFoto.setOnClickListener{
            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(it, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            var img = data?.extras?.get("data") as Bitmap
            ivFoto.setImageBitmap(img)
        }
    }
}
