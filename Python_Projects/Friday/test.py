import speech_recognition as sr

# obtain audio from the microphone
r = sr.Recognizer()
with sr.Microphone() as source:
    print("Say something!")
    r.adjust_for_ambient_noise(source)
    audio = r.listen(source)

# recognize speech using Sphinx
try:
    #print("Sphinx thinks you said " + r.recognize_sphinx(audio))
    print("Sphinx thinks you said " + r.recognize_google(audio))
except sr.UnknownValueError:
    print("Sphinx could not understand audio")
except sr.RequestError as e:
    print("Sphinx error; {0}".format(e))