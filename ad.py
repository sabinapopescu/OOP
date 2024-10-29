import tkinter as tk
import random

root = tk.Tk()
root.attributes("-fullscreen", True)
root.attributes("-topmost", True)
root.overrideredirect(1)
root.config(bg="white")
root.wm_attributes("-transparentcolor", "white")

def create_heart():
    x = random.randint(0, root.winfo_screenwidth())
    y = root.winfo_screenheight()
    heart = tk.Label(root, text="❤", font=("Arial", 24), fg="red", bg="white")
    heart.place(x=x, y=y)

    def animate():
        nonlocal y
        y -= 5
        if y < -50:
            heart.destroy()
        else:
            heart.place(x=x, y=y)
            root.after(50, animate)

    animate()
def start_animation():
    create_heart()
    root.after(700, start_animation)


start_animation()

root.mainloop()
