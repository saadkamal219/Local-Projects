from gtts import gTTS
import os

fh = open('text.txt', 'r')
my = fh.read().replace("\n", " ")
language = 'en'

output=gTTS(text=my,lang=language,slow=False)

output.save('Candidate_registration_completion.mp3')

fh.close()

# os.system('start output.mp3')
