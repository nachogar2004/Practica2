package edu.comillas.icai.gitt.pat.spring.mvc;

import edu.comillas.icai.gitt.pat.spring.mvc.ModeloCarrito;
import edu.comillas.icai.gitt.pat.spring.mvc.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class ControladorRest {

    private final CarritoService carritoService;

    public ControladorRest(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public List<ModeloCarrito> obtenerTodos() {
        return carritoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloCarrito> obtenerPorId(@PathVariable Long id) {
        return carritoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ModeloCarrito> crear(@RequestBody ModeloCarrito carrito) {
        ModeloCarrito nuevo = carritoService.crear(carrito);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloCarrito> actualizar(@PathVariable Long id,
                                              @RequestBody ModeloCarrito carrito) {
        return carritoService.actualizar(id, carrito)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (carritoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
