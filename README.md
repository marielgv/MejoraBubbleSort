# Bitácora de Interacción con IA - Proyecto Bubble Sort

En este archivo se detallan los "prompts" y las consultas realizadas a la IA (Gemini) para el desarrollo, corrección y visualización de los resultados de la comparativa de algoritmos de ordenamiento.

## 1. Consultas sobre el Código (Java)
* **Consulta:** "¿Por qué me muestra este texto subrayado, especialmente printf?"
* **Resultado:** Se identificó que las líneas amarillas eran advertencias de SonarQube (reglas java:S106 y java:S3457) relacionadas con el uso de `System.out` y el formato de `printf`. Se confirmó que el código era funcional para fines académicos.

## 3. Resolución de Problemas de Gráficos
* **Problema:** El gráfico no mostraba las barras del algoritmo optimizado debido a la enorme diferencia de magnitud (5,409,700 ns vs 6,700 ns).
* **Prompts de solución:** Se solicitaron pasos para visualizar ambos datos simultáneamente.
* **Solución técnica:** 1. Re-selección manual de series para incluir "Tradicional" y "Optimizado".
    2. Aplicación de **Escala Logarítmica (Base 10)** en el eje vertical para permitir la visualización de valores con diferencias de escala extremas.

## Conclusión Técnica
Gracias a la interacción con la IA, se logró una representación visual correcta donde se aprecia que, en un escenario ya ordenado, el Bubble Sort Optimizado es de magnitud más eficiente que el tradicional.

