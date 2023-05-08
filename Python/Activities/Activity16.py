class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")


car1 = Car("Ford", "Ikon", "2015", "Manual", "Grey")
car2 = Car("Maruti", "Ertiga", "2020", "Manual", "Grey")
car3 = Car("Audi", "Supreme", "2030", "Automatic", "Red")

car1.accelerate()
car2.accelerate()
car3.accelerate()
car3.stop()
car2.stop()
car1.stop()
