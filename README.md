# TP-PB2-SistemaCazadoresdeRecompensas-2025

# Trabajo Práctico en Pares: Sistema de Cazadores de Recompensas

El objetivo de este trabajo práctico es desarrollar en equipo un sistema de software que modele el universo de cazadores de recompensas y prófugos, aplicando **programación orientada a objetos, buenas prácticas de desarrollo colaborativo y control de versiones con GitHub**.

## Modalidad de Trabajo

- El trabajo se realizará en equipos de a dos personas. Se espera una participación **colaborativa y equitativa**, tanto en la implementación del sistema como en la toma de decisiones, diseño, pruebas y documentación.

- Cada equipo deberá:
  - Crear un repositorio compartido en GitHub para alojar el proyecto.
  - Agregar a ambos integrantes como colaboradores del repositorio.
  - Comunicar al docente por mensajería (u otro medio institucional indicado) los nombres de los integrantes y el enlace al repositorio.

- El seguimiento incluirá la revisión del historial de commits, issues, pull requests y demás actividades dentro del repositorio, con foco en la **colaboración real y continua de ambos integrantes**.

## Actividades esperadas

1. **Diseño e implementación del sistema**, cumpliendo los requisitos funcionales provistos en el enunciado (capturas, intimidación, evolución de prófugos y reportes).
2. Aplicar **principios de diseño orientado a objetos**: herencia, polimorfismo, composición, delegación, cohesión y bajo acoplamiento.
3. Utilizar **TDD (Test-Driven Development)** para validar la lógica del sistema con **JUnit-4**.
4. Mantener un flujo de trabajo con commits frecuentes y significativos por parte de ambos integrantes.
5. Usar GitHub para organizar tareas y dividir el trabajo.
6. Estructura del proyecto:
   - Proyecto Java tradicional con carpetas `src`, `test`, etc.
   - Convenciones de nomenclatura: `UpperCamelCase` para clases, `lowerCamelCase` para métodos/variables.

## Requisitos mínimos para aprobar

| Requisito               | Detalle                                                                 |
|-------------------------|-------------------------------------------------------------------------|
| Diseño completo         | Implementa todas las partes del enunciado (captura, evolución, reportes). |
| Buen uso de OOP         | Herencia, polimorfismo y/o composición aplicados correctamente.         |
| Trabajo en equipo       | Ambos integrantes realizaron al menos el 40% de los commits.            |
| Uso de GitHub           | Commits con mensajes claros, uso de ramas, pull requests.               |
| Código probado          | Tests con JUnit (mínimo 70% de cobertura).                              |
| Código legible          | Nombres claros, métodos cortos, responsabilidades bien definidas.       |

## Recomendaciones

- Usen **pull requests** para revisar el trabajo del otro.
- Dividan responsabilidades pero compartan conocimiento.
- Si un integrante se atrasa, el equipo debe apoyarlo para cumplir el plazo.

---

# Enunciado: Cazadores de Recompensas

## Tipos de Cazadores
- **Cazadores Urbanos**: Especialistas en entornos civiles.
- **Cazadores Rurales**: Expertos en zonas agrestes.
- **Cazadores Sigilosos**: Capturas discretas.

## Prófugos
- **Nivel de inocencia**: Valor que indica culpabilidad (más bajo = más culpable).
- **Nivel de habilidad**: Entre 1 y 100 (capacidad de evasión).
- **Atributo nervioso**: Sí/No.

## Parte I - Proceso de Captura
1. **Condiciones generales**:
   - Experiencia del cazador > Inocencia del prófugo.
2. **Condiciones específicas**:
   - **Sigiloso**: Habilidad del prófugo < 50.
   - **Rural**: Prófugo debe ser nervioso.
   - **Urbano**: Prófugo no debe ser nervioso.
3. **Intimidación**:
   - Reduce inocencia en 2 unidades.
   - Efectos adicionales según tipo de cazador.

## Parte II - Evolución de Prófugos
- **Artes marciales avanzadas**: Duplica habilidad (máx. 100).
- **Entrenamiento de elite**: Elimina atributo "nervioso".
- **Protección legal**: Inocencia nunca < 40.

## Parte III - Reportes
- Prófugos capturados.
- Prófugo más hábil capturado.
- Cazador con más capturas.

---

**Plazo de entrega**: Viernes 04 de julio, 23:59 hs.
