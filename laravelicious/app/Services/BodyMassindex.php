<?php
namespace App\Services;

/**
 * Class handling calculation of body mass index value based on age and gender
 *
 * @author zolana
 */
class BodyMassindex 
{  
    protected $age;
    protected $gender;
    protected $height;
    protected $weight;
   
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
   
    public function __construct(array $data) 
    {
        $this->initProperties($data);
    }

    public function caclulate()
    {      
        $idealBmiValue = $this->getIdealBmiValue();
        $userBmiValue  = $this->getUserBmiValue();
        
        $idealWeigth = $this->getIdealWeigth(
            $idealBmiValue,
            floatval($this->height)
        );     
        
        $toLooseWeight = (floatval($this->weight) - $idealWeigth);
        
        $result = array(
            'gender'     => $this->gender,
            'age'        => $this->age,            
            'height'     => $this->height,
            'weight'     => $this->weight,
            'userBmi'    => $userBmiValue,
            'idealBmi'   => min($idealBmiValue,$userBmiValue),
            'idealWeigth'=> min($idealWeigth,floatval($this->weight)) ,
            'toLooseWeight' => max(0, $toLooseWeight)
        );
        
        return $result;
    }
    
    protected function getUserBmiValue()
    {
        $heigth = floatval($this->height);
        $weigth = floatval($this->weight);
        $index  = floor($weigth / pow($heigth, 2));
        
        return $index;
    }        

    protected function getIdealBmiValue()
    {
        $idealBmiValue = 0;
    
        $age = intval($this->age);
        
        $ageRanges = $this->bmiTable[$this->gender]['age'];
        
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
        return ($idealBmiValue * pow($userHeight, 2));
    }  
    
    protected function initProperties(array $data)
    {
        foreach ($data as $property => $value) {
            $this->initProperty($data, $property, $value);
        }
    }        

    protected function initProperty(array $data, $property, $value)
    {
        if(!array_key_exists($property, $data)){
            throw new \Exception(
                sprintf(
                    'property %s not found in [%s]',
                     $property,
                     implode(',', $data)   
                )
            );        
        }
        
        $this->$property = $value;
    }        
}
