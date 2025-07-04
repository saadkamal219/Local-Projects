import turtle 
import time
import random
import pygame
from datetime import datetime
import pyttsx3
import random

# import fonttools

# snake_head_color = input("Enter the color of snake head: ")
# snake_body_color = input("Enter the color of snake body: ")

#sound

#Score Counter and history tracker

def log_score(score, high_score, is_new_high=False):
    now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    with open("score_history.txt", "a") as history_file:
        if is_new_high:
            history_file.write(f"[{now}] Score: {score} (New High Score!)\n")
        else:
            history_file.write(f"[{now}] Score: {score}\n")

#Function ends here !! Don't worry to much !!!

pygame.init()

hit = pygame.mixer.Sound("hit.mp3")
no = pygame.mixer.Sound("nooooo.ogg")
eat = pygame.mixer.Sound("eat.mp3")
click = pygame.mixer.Sound("click.mp3")
joy = pygame.mixer.Sound("joy.mp3")
hiss = pygame.mixer.Sound("hiss.mp3")
up = pygame.mixer.Sound("up.mp3")
down = pygame.mixer.Sound("down.mp3")
right = pygame.mixer.Sound("right.mp3")
left = pygame.mixer.Sound("left.mp3")
less_then_10 = pygame.mixer.Sound("less_then_10.mp3")
more_then_40 = pygame.mixer.Sound("more_then_40.mp3")
new_high_score = pygame.mixer.Sound("new_high_score.mp3")
reguler1 = pygame.mixer.Sound("reguler1.mp3")
reguler2 = pygame.mixer.Sound("reguler2.mp3")
reguler3 = pygame.mixer.Sound("reguler3.mp3")

snake_head_color = "#eeff03"
snake_body_color = "#20ff03"

sum = 0

# snake_head_color = turtle.Screen()
# snake_head_color.setup(0, 0)
# turtle.textinput("OOP II Project - Snake Game", "Enter the color of snake head: ")

# snake_body_color = turtle.Screen()
# snake_head_color.setup(0, 0)
# turtle.textinput("OOP II Project - Snake Game", "Enter the color of snake body: ")

f = open("high_score.txt", "r")

delay = 0.1
speed_of_snake = 10
score = 0
high_score = int(f.read())
f.close()

#set up the screen
window = turtle.Screen()
hiss.play()
window.title("Python")
window.bgcolor("black")
window.setup(width = 600, height = 600)
window.tracer(0) #turns off the animation no the screen

#game code start here

#Creating custom shapes

# custom_shape = turtle.Turtle()
 
turtle.register_shape('snake_head.gif')
turtle.register_shape('up.gif')
turtle.register_shape('down.gif')
turtle.register_shape('left.gif')
turtle.register_shape('right.gif')

#Snake Head

snake_head = turtle.Turtle()
snake_head.speed(0) #fastest animation speed, no delay at all
snake_head.shape("up.gif")
snake_head.left(90)
# snake_head.width = 
snake_head.fillcolor(snake_head_color)
snake_head.pencolor(snake_head_color)
snake_head.penup() #does not draw anything on the screen
snake_head.goto(0,0)
snake_head.direction = "stop"

#Snake Food

snake_food = turtle.Turtle()
snake_food.speed(0) #fastest animation speed, no delay at all
snake_food.shape("turtle")
# snake_food.left(90)
# snake_food.setup(10, 10)
snake_food.color("red")
snake_food.penup() #does not draw anything on the screen
snake_food.goto(0,100)
# snake_food.direction = "right"

#Snake Body

segments = []

#Score Writing

pen = turtle.Turtle()
pen.speed(0)
pen.shape("square")
pen.color("white")
pen.penup()
pen.hideturtle()
pen.goto(0,255)
f5 = open("high_score.txt", "r")
s = open("last_score.txt", "r")
pen.write("Score: {} | Last Score: {} | High Score: {}".format(0, s.read(), f5.read()), align="center", font=("courier", 16, "normal"))
f5.close()
s.close()

#score board to snake pit difference
pen1 = turtle.Turtle()
pen1.speed(0)
pen1.shape("square")
pen1.color("white")
pen1.penup()
pen1.hideturtle()
pen1.goto(0,225)
# pen.write("Score: 0     High Score: 0", align="center", font=("courier", 24, "normal"))
pen1.write("-----------------------------------------------------", align="center", font=("courier", 24, "bold"))


# functions

def move():

    if snake_head.direction == "up":
        y_axis = snake_head.ycor()
        snake_head.sety(y_axis + speed_of_snake)
    
    if snake_head.direction == "down":
        y_axis = snake_head.ycor()
        snake_head.sety(y_axis - speed_of_snake)

    if snake_head.direction == "left":
        x_axis = snake_head.xcor()
        snake_head.setx(x_axis - speed_of_snake)

    if snake_head.direction == "right":
        x_axis = snake_head.xcor()
        snake_head.setx(x_axis + speed_of_snake)
    # if snake_head.direction == "s":
    #     snake_head.setx(snake_head.xcor())
    #     snake_head.sety(snake_head.ycor())

def go_up():
    if snake_head.direction != "down":
        snake_head.direction = "up"
        snake_head.shape("up.gif")
        up.play()

def go_down():
    if snake_head.direction != "up":
        snake_head.direction = "down"
        snake_head.shape("down.gif")
        down.play()

def go_left():
    if snake_head.direction != "right":
        snake_head.direction = "left"
        snake_head.shape("left.gif")
        left.play()

def go_right():
    if snake_head.direction != "left":
        snake_head.direction = "right"
        snake_head.shape("right.gif")
        right.play()

# def stop():
#     if snake_head.direction == "up":
#         snake_head.direction = "up"
#     if snake_head.direction == "down":
#         snake_head.direction = "down"
#     if snake_head.direction == "left":
#         snake_head.direction = "left"
#     if snake_head.direction == "right":
#         snake_head.direction = "right"

def speakScore(score, high_score):
    if score < 10:
        less_then_10.play()
    elif score > 40:
        more_then_40.play()
    elif score > high_score:
        new_high_score.play()
    else:
        attempt = random.choice([1, 2, 3])

        if attempt == 1: reguler1.play()
        elif attempt == 2: reguler2.play()
        elif attempt == 3: reguler3.play()

        


#keyboard bindings

window.listen()
window.onkeypress(go_up, "Up")
window.onkeypress(go_down, "Down")
window.onkeypress(go_left, "Left")
window.onkeypress(go_right, "Right")
# window.onkeypress(stop, "s")

sum = 0

#main game loop

while True:

    window.update()

    #check for collision with the border
    if snake_head.xcor() > 290 or snake_head.xcor() < -290 or snake_head.ycor() > 220 or snake_head.ycor() < -290:
        
        hit.play()
        # no.play()

        time.sleep(1)
        snake_head.goto(0,0)
        snake_head.direction = "stop"
        # segments.clear()

        #hide the segments:
        for segment in segments:
            segment.goto(1000,1000)
        
        #clear the segments list
        segments.clear()

        sw = open("last_score.txt", "w")
        last_score_str = str(score)
        sw.write(last_score_str)
        sw.close()

        # Log score history

        log_score(score, high_score, score == high_score)

        # Speak score

        speakScore(score, high_score)

        #reset the score

        score = 0

        #reset the delay
        delay = 0.1

        pen.clear()
        # pen1.clear()
        f1 = open("high_score.txt", "r")
        s3 = open("last_score.txt", "r")
        pen.write("Score: {} | Last Score: {} | High Score: {}".format(score, s3.read(), f1.read()), align = "center", font = ("courier", 16, "normal"))
        f1.close()
        s3.close()

    #check for a collision with the food
    if snake_head.distance(snake_food) < speed_of_snake:
        #move the food to a random spot of the module

        eat.play()

        x = random.randint(-250, 250)
        y = random.randint(-250, 200)
        snake_food.left(random.randint(-360, 360))
        snake_food.goto(x,y)
        # speed_of_snake += 1

        #add a segment
        new_segment = turtle.Turtle()
        new_segment.speed(0)
        new_segment.shape("square")
        new_segment.fillcolor(snake_body_color)
        new_segment.pencolor("black")
        new_segment.penup()
        segments.append(new_segment)

        #shorten the delay
        delay -= 0.001

        #increase the score

        if score < 60:
            score += 1
        elif score >= 60 and score < 80:
            score += 4
        elif score > 80:
            score += 8

        if score > high_score:
            high_score = score

        f2 = open("high_score.txt", "w")
        high_score_str = str(high_score)
        f2.write(high_score_str)
        f2.close()

        pen.clear()
        # pen1.close()
        f3 = open("high_score.txt", "r")
        s2 = open("last_score.txt", "r")
        pen.write("Score: {} | Last Score: {} | High Score: {}".format(score, s2.read(), f3.read()), align = "center", font = ("courier", 16, "normal"))
        f3.close()
        s2.close()

    #check for colision with the body
    for segment in segments:
        if segment.distance(snake_head) < 10:
            hit.play()
            time.sleep(1)
            snake_head.goto(0,0)
            snake_head.direction = "stop"
            # segments.clear()

            #hide the segments:
            for segment in segments:
                segment.goto(1000,1000)
        
            #clear the segments list
            segments.clear()

            sw2 = open("last_score.txt", "w")
            last_score_str = str(score)
            sw2.write(last_score_str)
            sw2.close()

            # Log score history

            log_score(score, high_score, score == high_score)

            # Speak score
            speakScore(score, high_score)

            #reset the score

            score = 0

            #reset the delay
            delay = 0.1

            pen.clear()
            # pen1.close()
            f4 = open("high_score.txt", "r")
            s4 = open("last_score.txt", "r")
            pen.write("Score: {} | Last Score: {} | High Score: {}".format(score, s4.read(), f4.read()), align = "center", font = ("courier", 16, "normal"))
            # f4.close()
            # s4.close()


    #move the end segments first in reverse order
    for index in range(len(segments)-1, 0, -1):
        x = segments[index - 1].xcor()
        y = segments[index - 1].ycor()
        segments[index].goto(x, y)
    
    #move segment 0 to here the head is
    if len(segments) > 0:
        x = snake_head.xcor()
        y = snake_head.ycor()
        segments[0].goto(x, y)
    
    move()

    time.sleep(delay) #stops the program

#game code end here

window.mainloop() #keep the game window open for user
