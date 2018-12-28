#tutorial from lynda.com

from tkinter import *
from tkinter import ttk

class HelloWorld:
    def __init__(self, master):
        self.label = ttk.Label(master, text = "Hello, Tkinter!")
        self.label.grid(row = 0, column = 0, columnspan = 2)

        ttk.Button(master, text = "Texas",
                   command = self.texas_hello).grid(row = 1, column = 0)
        ttk.Button(master, text = "Hawaii",
                   command = self.hawaii_hello).grid(row = 1, column = 1)

    def texas_hello(self):
        self.label.config(text = "Howdy, Tkinter!")

    def hawaii_hello(self):
        self.label.config(text = "Aloha, Tkinter")

def main():
    root = Tk()
    app = HelloWorld(root)
    root.mainloop()

if __name__ == "__main__": main()

##root = Tk()
##button = ttk.Button(root, text='Click Me').pack()
##button['text'] = 'Press Me'
##button.config(text = 'Push Me')
##ttk.Label(root, text= 'Hello Tkinter!').pack()
