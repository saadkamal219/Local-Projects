from gtts import gTTS
import os

fh = open('script.txt', 'r')
my = fh.read().replace("\n", " ")
language = 'en'

output=gTTS(text=my,lang=language,slow=False)

output.save('reguler3.mp3')

fh.close()

# os.system('start output.mp3')
