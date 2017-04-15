<div id='head'>
    <a style="text-decoration:none" href="./../playground">&lt;&lt; Home</a>
</div>    
<div id='content' style="margin-top:10px" style="float:left">
    {{ Form::open(array('url' => 'playground/calculate')) }}
    <div style="margin-bottom:10px">    
        {{ Form::label('gender', 'Gender:')}}
        {{ Form::select('gender', ['male' => 'Male', 'female' => 'Female'], 'your gender') }}
    </div>
    <div style="margin-bottom:10px">
        {{ Form::label('age', 'Age:')}}
        {{ Form::text('age') }}
    </div>
    <div style="margin-bottom:10px">
        {{ Form::label('heigth', 'Height(m):')}}
        {{ Form::text('hoehe','1.70') }}
    </div>
    <div style="margin-bottom:10px">
        {{ Form::label('weigth', 'Weight(kg):')}}
        {{ Form::text('gewicht','70.5') }}
    </div>
    {{ Form::submit('calculate')}}
    {{ Form::close() }}
</div>    