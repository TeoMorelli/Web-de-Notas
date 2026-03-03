import { useEffect, useState } from "react";
import { obtenerNotas, crearNota } from "./services/notaService";
import "./App.css";

function App() {
  const [notas, setNotas] = useState([]);
  const [titulo, setTitulo] = useState("");
  const [contenido, setContenido] = useState("");

  useEffect(() => {
    cargarNotas();
  }, []);

  const cargarNotas = async () => {
    try {
      const data = await obtenerNotas();
      setNotas(data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleCrear = async () => {
    if (!titulo || !contenido) return;

    try {
      const nuevaNota = await crearNota({ titulo, contenido });
      setNotas([...notas, nuevaNota]);
      setTitulo("");
      setContenido("");
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="container">
      <h1>Mis Notas</h1>

      <div className="form">
        <input
          type="text"
          placeholder="Título"
          value={titulo}
          onChange={(e) => setTitulo(e.target.value)}
        />

        <textarea
          placeholder="Contenido"
          value={contenido}
          onChange={(e) => setContenido(e.target.value)}
        />

        <button onClick={handleCrear}>Crear Nota</button>
      </div>

      <div className="lista">
        {notas.map((nota) => (
          <div key={nota.id} className="nota">
            <h3>{nota.titulo}</h3>
            <p>{nota.contenido}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;