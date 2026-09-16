from AlgebraVectorial import AlgebraVectorial

# Vectores de prueba
a = AlgebraVectorial(4, 0)
b = AlgebraVectorial(0, 3)   # a y b son perpendiculares
c = AlgebraVectorial(8, 0)   # c es paralelo a a (c = 2*a)

print("Vector a:", a.x, a.y)
print("Vector b:", b.x, b.y)
print("Vector c:", c.x, c.y)
print()

# (1) Perpendicularidad - probando los 4 métodos
print("--- Perpendicularidad entre a y b ---")
print("Método 1 (|a+b|=|a-b|):", a.es_perpendicular(b, metodo=1))
print("Método 2 (|a-b|=|b-a|):", a.es_perpendicular(b, metodo=2))
print("Método 3 (a.b=0):", a.es_perpendicular(b, metodo=3))
print("Método 4 (|a+b|^2=|a|^2+|b|^2):", a.es_perpendicular(b, metodo=4))
print()

# (2) Paralelismo - probando los 2 métodos
print("--- Paralelismo entre a y c ---")
print("Método 1 (a=r*b, r=2):", c.es_paralela(a, metodo=1, r=2))
print("Método 2 (a x b = 0):", c.es_paralela(a, metodo=2))
print()

# (3) Proyección de a sobre b
proy = a.proyeccion_sobre(b)
print("--- Proyección de a sobre b ---")
print("Proy_b(a) =", proy.x, proy.y)
print()

# (4) Componente de a en b
comp = a.componente_en(b)
print("--- Componente de a en b ---")
print("Comp_b(a) =", comp)