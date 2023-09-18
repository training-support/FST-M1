class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")

car1 = Car("Ford", "Fido", "2010", "Manual", "Blue")
car2 = Car("Maruti", "Alto", "2005", "Manual", "White")
car3 = Car("Audi", "AU800", "2019", "Automatic", "Grey")

car1.accelerate()
car1.stop()