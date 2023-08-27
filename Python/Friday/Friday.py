import speech_recognition as sr
import pyttsx3
import pywhatkit
import pyjokes
import datetime
import wikipedia
import os

global com1

buffer = sr.Recognizer()
engine = pyttsx3.init()

volume = engine.getProperty('volume')
engine.setProperty('volume', volume+10)
voices = engine.getProperty('voices')
rate = engine.getProperty('rate')
engine.setProperty('rate', rate-30)
engine.setProperty('voice', 'english+f2')

engine.say('hello boss')
engine.say('How may i help you')
engine.runAndWait()

def talk(text):
    engine.say(text)
    engine.runAndWait()

def quit():
    engine.say('boss, I am your Friday. Call me by my name')
    engine.runAndWait()

def take_command():

    try:

        with sr.Microphone() as source:
            print("Listening...")
            buffer.adjust_for_ambient_noise(source)
            voice = buffer.listen(source)
            com1 = buffer.recognize_google(voice)
            com1 = com1.lower()
            if 'friday' in com1:
                com1 = com1.replace('friday', '')
                print(com1)
            else:
                quit()

    except:
        pass

    return com1

access = 1

def run():
    comm = take_command()
    print(comm) 

    if 'play' in comm:
        comm = comm.replace('play', '')
        talk('playing' + comm) 
        # print(comm)\
        pywhatkit.playonyt(comm)

    elif 'time' in comm:
        time = datetime.datetime.now().strftime('%I:%M %p')
        print(time)
        talk('Current time is ' + time)
    
    elif 'what is' in comm:
        obj = comm.replace('what is', '')
        info = wikipedia.summary(obj, 2)
        print(info)
        talk(info)

    elif 'who are you' in comm:
        # im = comm.replace('who are you', '')
        print("I am Friday, Mr. Saad's personal assistant")
        talk("I am Friday, Mr. Saad's personal assistant")
    
    elif 'joke' in comm:
        joke = pyjokes.get_joke()
        print(joke)
        talk(joke)

    elif 'reboot' in comm:
        print("rebooting....")
        talk("rebooting")
        os.system('reboot')
    
    elif 'create folder' in comm:
        talk("creating folder...")
        talk("Tell me the folder name........")
        name = take_command()

        os.system('cd Desktop && mkdir ' + name)

        talk("Folder created")
        # os.system('mkdir File')
    
    elif 'hi' in comm:
        talk("hello boss")
    
    elif 'how are you' in comm:
        talk('I am fine, boss')
        talk('What about you?')
    
    elif 'fine' in comm:
        talk("Good to hear that")
    
    elif 'not good' in comm:
        talk("What happed?")

    elif 'nano' in comm:
        talk("Expensive learning though")
    
    elif 'atik' in comm:
        talk("One of my co-creator")
    
    elif 'quit' in comm:
        access = 0

    else:
        talk("Please repeat the command again")

while True:
    
    run()

    if access == 0:
        break