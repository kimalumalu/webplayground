<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PlaygroundController extends Controller
{
    protected $bmiTable = array(
        'male'  => array(
            'age'=> array(
                '20-24' => '25',
                '25-29' => '25',
                '30-34' => '26',
                '35-39' => '27',
                '40-44' => '29',
                '45-49' => '31',
                '50-59' => '33',
                '60-100000000000000'=>'34'
            )
        ),
        'female'=> array(
            'age'=> array(
                '20-24' => '25',
                '25-29' => '26',
                '30-34' => '26',
                '35-39' => '27',
                '40-44' => '28',
                '45-49' => '28',
                '50-59' => '29',
                '60-10000000000000'=>'30' 
            )
        )
    );
    
    public function bodyMassIndex(Request $request)
    {
        return view('bodymassindex');
    }
    
    public function calculate(Request $request)
    {      
        $idealBmiValue = $this->getIdealBmiValue($request);
        $userBmiValue  = $this->getUserBmiValue($request);
        
        $idealWeigth = $this->getIdealWeigth(
            $idealBmiValue,
            floatval($request->hoehe)
        );     
        
        $toLooseWeight = (floatval($request->gewicht) - $idealWeigth);
        
        $result = array(
            'gender'     => $request->gender,
            'age'        => $request->age,            
            'height'     => $request->hoehe,
            'weight'     => $request->gewicht,
            'userBmi'    => $userBmiValue,
            'idealBmi'   => min($idealBmiValue,$userBmiValue),
            'idealWeigth'=> min($idealWeigth,floatval($request->gewicht)) ,
            'toLooseWeight' => max(0, $toLooseWeight)
        );
        
        return View('calculate', $result);
    }
    
    protected function getUserBmiValue(Request $request)
    {
        $heigth = floatval($request->hoehe);
        $weigth = floatval($request->gewicht);
        $index  = floor($weigth / pow($heigth, 2));
        
        return $index;
    }        

    protected function getIdealBmiValue(Request $request)
    {
        $idealBmiValue = 0;
    
        $age = intval($request->age);
        
        $ageRanges = $this->bmiTable[$request->gender]['age'];
        
        foreach($ageRanges as $ageRange => $bmiValue){
            $ageValues  = explode('-', $ageRange);
            $minimalAge = intval($ageValues[0]);
            $maximalAge = intval($ageValues[1]);
            
            if($minimalAge <= $age && $age <= $maximalAge){
                $idealBmiValue = $bmiValue;
                break;                
            }
        }
        
        return $idealBmiValue;     
    } 
    
    protected function getIdealWeigth($idealBmiValue, $userHeight)
    {
        $idealWeight = $idealBmiValue * pow($userHeight, 2);
        return $idealWeight;
    }        
            
}  
