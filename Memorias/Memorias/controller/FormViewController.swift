//
//  ViewController.swift
//  Memorias
//
//  Created by IFPB on 06/12/2019.
//  Copyright © 2019 IFPB. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {

    
    @IBOutlet weak var tfopinar: UITextField!
    @IBOutlet weak var swGostar: UISwitch!
    @IBOutlet weak var tvComenta: UITextView!
    @IBOutlet weak var stNota: UIStepper!
    @IBOutlet weak var slRecomenda: UISlider!
    @IBOutlet weak var lbNota: UILabel!
    @IBOutlet weak var lbRecomenda: UILabel!
    var dao: MemoriaDAO!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.dao = MemoriaDAO()
    }
    
    @IBAction func nota(_ sender: Any) {
        self.lbNota.text = String(Int(self.stNota.value))
    }
    
    @IBAction func recomendar(_ sender: Any) {
        self.lbRecomenda.text = String(Int(self.slRecomenda.value))
    }
    
    @IBAction func salvar(_ sender: Any) {
        let assunto = self.tfopinar.text
        let gostou = self.swGostar.isOn
        let comentarios = self.tvComenta.text
        let nota = Int(self.stNota.value)
        let recomendacao = Int(self.slRecomenda.value)
        
        
        if (self.dao.add(assunto: assunto!, gostou: gostou, comentarios: comentarios!, nota: nota, recomendacao: recomendacao)) {
            let alert = UIAlertController(title: "Atencao", message: "Deu certo", preferredStyle: UIAlertController.Style.alert)
            
            alert.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: {
                (UIAlertController) in
                    self.navigationController?.popViewController(animated: true)

            }))
            
            self.present(alert, animated: true, completion: nil)
        } else {
            let alert = UIAlertController(title: "Atencao", message: "Deu problema", preferredStyle: UIAlertController.Style.alert)
            alert.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.cancel, handler: nil))
            self.present(alert, animated: true, completion: nil)
        }
        
    }
}

