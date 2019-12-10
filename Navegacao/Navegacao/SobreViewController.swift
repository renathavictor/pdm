//
//  SobreViewController.swift
//  Navegacao
//
//  Created by IFPB on 07/11/2019.
//  Copyright © 2019 IFPB. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {

    @IBOutlet weak var lbNome: UILabel!
    var pessoa: Pessoa!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.dismiss(animated: true, completion: nil)
    }
}
