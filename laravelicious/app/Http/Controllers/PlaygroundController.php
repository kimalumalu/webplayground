<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PlaygroundController extends Controller
{
    public function bodyMassIndex(Request $request)
    {
        return view('bodymassindex');
    }
    
    public function calculate(Request $request)
    {
        $heigth = floatval($request->hoehe);
        $weigth = floatval($request->gewicht);
        $index  = ($weigth / pow($heigth, 2));        
                
        $result = array(
            'index' => $index
        );
        
        return View('calculate', $result);
    }        
}
