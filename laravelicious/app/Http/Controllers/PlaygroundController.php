<?php

namespace App\Http\Controllers;

use App\Services;
use Illuminate\Http\Request;

class PlaygroundController extends Controller
{    
    public function bodyMassIndex(Request $request)
    {
        return view('bodymassindex');
    }
    
    public function calculate(Request $request)
    {     
        $data = array(
            'age'   => $request->age,
            'gender'=> $request->gender,
            'height'=> $request->hoehe,
            'weight'=> $request->gewicht
        );
        
        $service = new Services\BodyMassindex($data);
        
        return View('calculate', $service->caclulate());
    }  
}  
