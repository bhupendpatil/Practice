//
//  ViewController.swift
//  ExHello
//
//  Created by Bhupend Patil on 21/02/19.
//  Copyright © 2019 Bhupend Patil. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    @IBAction func showMessage(sender: UIButton){
        var emojiDict: [String:String] = [
            "👾":"Alien",
            "👻":"Ghost",
            "🤓":"Nerd",
            "🤖":"Robot"
        ]
        
        let selectButton = sender
        
        if let wordToLookup = selectButton.titleLabel?.text{
            
            let meaning = emojiDict[wordToLookup]
            
            let alertController = UIAlertController(title: "Meaning", message: meaning, preferredStyle: UIAlertController.Style.alert)
            
            alertController.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: nil))
            
            present(alertController,animated: true,completion: nil)
            
        }
    }
}

