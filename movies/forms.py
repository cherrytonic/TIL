from logging import PlaceHolder
from django import forms
from .models import Movie

genre_choice = [('코미디', '코미디'), ('액션', '액션'), ('판타지', '판타지')]
class MovieForm(forms.ModelForm):
    genre = forms.ChoiceField(choices=genre_choice, widget=forms.Select())
    score = forms.IntegerField(
    widget=forms.NumberInput(
        attrs={'placeholder': 'Score', 'step':0.5, 'min':0, 'max':5}
    ))
    release_date = forms.DateField(widget=forms.DateInput(
        attrs={'type':'date'}
    ))
    class Meta:
        model = Movie
        fields = '__all__'