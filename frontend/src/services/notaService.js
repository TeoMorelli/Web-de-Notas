const API_URL = "http://localhost:8080/api/Notas";

export const obtenerNotas = async () => {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error("Error al obtener notas");
  return await response.json();
};

export const crearNota = async (nota) => {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(nota)
  });

  if (!response.ok) throw new Error("Error al crear nota");
  return await response.json();
};
