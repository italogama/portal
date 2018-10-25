$(document).ready(function(){
	
	aplicarListeners();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#origem').val('');
	$('#destino').val('');
	$('#categoria').val('');
};

var aplicarListeners = function() {
	$('#modal-pacote').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
	
		$.get(window.location.href.concat('/').concat(id),function(pacote){
				
				$('#id').val(pacote.id);
				$('#origem').val(pacote.origem);
				$('#destino').val(pacote.destino);
				$('#categoria').val(pacote.categoria);
				$('#modal-pacote').modal('show');
			});
	});
	
	$('.btn-deletar').on('click', function() {
		var id = $(this).parents('tr').data('id');
		var pacotes = $('#quantidade-pacotes').text();
		
		$.ajax({
			url : window.location.href.concat('/').concat(id),
			type: 'DELETE',
			success: function(result) {
				$('tr[data-id="'+id+'"]').remove();
				$('#quantidade-pacotes').text(pacotes - 1);
			}
		});
		
		
	});
	
	$('#btn-salvar').on('click', function() {
		var url = 'pacotes';
		
		var dadosPacote = $('#form-pacote').serialize();

		$.post(window.location.href , dadosPacote)
			.done(function(pagina){
			$('#secao-pacotes').html(pagina);
			aplicarListeners();
			
		})
		.fail(function(e) {
			console.log(e);
			alert('Erro ao salvar.');
		})
		.always(function() {
			$('#modal-pacote').modal('hide');
		});
	});
	
}