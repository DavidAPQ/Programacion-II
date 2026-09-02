from EcuacionLineal import EcuacionLineal

print("ECUACION CUADRATICA: ax^2 + bx + c = 0")

a = int(input("INGRESE (a): "))
b = int(input("INGRESE (b): "))
c = int(input("INGRESE (c): "))

ecuacion1 = EcuacionLineal(a, b, c)
discriminante = ecuacion1.getDiscriminante()

if (discriminante > 0):
    print(f"La ecuacion tiene 2 raices {ecuacion1.getRaiz1():.6f} y {ecuacion1.getRaiz2():.6f}")
elif (discriminante == 0):
    print(f"La ecuacion tiene solo 1 raiz {ecuacion1.getRaiz1():.3f}")
else:
    print("La ecuacion no tiene raices reales")