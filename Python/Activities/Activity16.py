class car:
    def __init__(self,manufacturer,model, make, transmission, color) :
        self.manufacturer =manufacturer
        self.model=model
        self.make =make
        self.transmission=transmission
        self.color =color

    def accelerate(self):
            print(self.manufacturer+" "+self.model+ "Is moving")
        
    def stop(self):
            print(self.manufacturer+" "+self.model+ "Is Stopped")

c1=car("Maruti","Suzuki","2011","Manual","Green")
c2=car("Honda","Jazz","2015","Automatic","Blue") 
c3=car("Audi","ZX","2022","Automatic","Red")

c1.accelerate()
c1.stop()
