class car:
    self.manufacturer="Honda"
    model="Brio"
    make="2020"
    transmission="manual"
    color="grey"
    def accelerate(self,manufacturer,model):
        print(self.manufacturer+self.model+"is moving")
    def stop(self,manufacturer,model):
        print(self.manufacturer+self.model+"has stopped")

car1 = car("Honda", "Brio", "2020", "Manual", "grey")
obj2 = car("Maruti", "800", "2013", "Manual", "Red")
obj3 = car("Suzuki", "Swift", "2017", "Automatic", "Black")

car1.accelerate()
car1.stop()
