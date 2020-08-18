<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-purchase-confirmation"
	var="actionPurchaseConfirmation" />
<div>
	<div class="d-flex padding-0">
		<%@ include file="/lg_lateral.jsp"%>

		<div id="general-content-container">
			<!-- COMPONENTE SUPERIOR DE NAVEGACION EN MOVIL -->
			<div class="mobile">
				<div class="d-flex justify-content-between bd-highlight mb-2">
					<div class="p-2 bd-highlight">
						<a href="https://www.telefonica.com/es/home"> <img
							src="<%=request.getContextPath()%>/images/flecha.jpg"
							class="header-mobile-flecha">
						</a>
					</div>
					<div class="p-2 bd-highlight"></div>
					<div class="p-2 bd-highlight">
						<img src="<%=request.getContextPath()%>/images/cerrar.jpg"
							class="header-mobile-cerrar">
					</div>
				</div>
			</div>
			<!-- ////////////////////////////////////////// -->
			<!-- CONTENIDO -->
			<form id="formQuestion" action="${actionPurchaseConfirmation}"
				method="POST">
				<div class="header-band desk">
					<label class="header-text">Confirmación</label>
				</div>
				<div class="row row-separation content-space">
					<h3 class="tittle">Confirma tu solicitud</h3>
				</div>

				<div class="plan">

					<div class="mobile">
						<div class="d-flex justify-content-between bd-highlight mb-2">
							<div class="p-2 bd-highlight">
								<label class="confirm-text-1">Plan</label>
							</div>
							<div class="p-2 bd-highlight"></div>
							<div class="p-2 bd-highlight"></div>
						</div>
					</div>

					<div class="row desk">
						<div class="col-md-1"></div>
						<div class="col-md-11">
							<label class="confirm-text-1">Plan</label>
						</div>
					</div>
					<!--  -->
					<div class="mobile">
						<div class="d-flex justify-content-between bd-highlight mb-2">
							<div class="p-2 bd-highlight">
								<label class="confirm-text-2 text-left">${shortName}</label><br>
								<label class="confirm-text-3 text-left">${description}</label>
							</div>
							<div class="p-2 bd-highlight"></div>
							<div class="p-2 bd-highlight">
								<label class="confirm-text-2 text-right">$
									${priceWithTaxes} </label>
							</div>
						</div>
					</div>


					<div class="row desk">
						<div class="hidden-sm-up col-md-1"></div>
						<div class="col-sm-8 col-md-6">
							<label class="confirm-text-2 text-left">${shortName}</label><br>
							<label class="confirm-text-3 text-left">${description}</label>
						</div>
						<div class="col-sm-4 col-md-2">
							<label class="confirm-text-2 text-right">$
								${priceWithTaxes}</label>
						</div>
						<div class="hidden-sm-up col-md-3"></div>
					</div>

					<!--  -->

					<div class="mobile">
						<div class="d-flex justify-content-between bd-highlight mb-2">
							<div class="p-2 bd-highlight">
								<span
									class="icon-icono-recarga-movil-filled icon-azul-portabilidad-movistar"></span>
								<label class="confirm-text-4 text-left">${topText}</label>
							</div>
							<div class="p-2 bd-highlight"></div>
							<div class="p-2 bd-highlight">
								<label class="confirm-text-4 text-right">-$00.00</label>
							</div>
						</div>
					</div>


					<div class="row desk">
						<div class="hidden-sm-up col-md-1"></div>
						<div class="col-sm-8 col-md-6">
							<span
								class="icon-icono-recarga-movil-filled icon-azul-portabilidad-movistar"></span>
							<label class="confirm-text-4 text-left">${topText}</label>
						</div>
						<div class="col-sm-4 col-md-2">
							<label class="confirm-text-4 text-right">-$00.00</label>
						</div>
						<div class="hidden-sm-up col-md-3"></div>
					</div>

					<!--  -->

					<div class="mobile">
						<div class="d-flex justify-content-between bd-highlight mb-2">
							<div class="p-2 bd-highlight">
								<label class="confirm-text-5 text-left">Chip Movitar</label><br>
								<label class="confirm-text-5 text-left">Subtotal</label><br>
								<label class="confirm-text-5 text-left">Impuestos y
									servicios</label>
							</div>
							<div class="p-2 bd-highlight"></div>
							<div class="p-2 bd-highlight">
								<label class="confirm-text-5 text-right">$0</label><br> <label
									class="confirm-text-5 text-right">$ ${price}</label><br> <label
									class="confirm-text-5 text-right">$ ${taxes}</label>
							</div>
						</div>
					</div>

					<div class="row desk">
						<div class="col-md-1"></div>
						<div class="col-md-6">
							<label class="confirm-text-5 text-left">Chip Movitar</label><br>
							<label class="confirm-text-5 text-left">Subtotal</label><br>
							<label class="confirm-text-5 text-left">Impuestos y
								servicios</label>
						</div>
						<div class="col-md-2">
							<label class="confirm-text-5 text-right">$0</label><br> <label
								class="confirm-text-5 text-right">$ ${price}</label><br> <label
								class="confirm-text-5 text-right">$ ${taxes}</label>
						</div>
						<div class="col-md-3"></div>
					</div>
					<!--  -->
					<hr>

					<div class="mobile">
						<div class="d-flex justify-content-between bd-highlight mb-2">
							<div class="p-2 bd-highlight">
								<label class="confirm-text-6 text-left">Total con
									impuestos incluidos</label>
							</div>
							<div class="p-2 bd-highlight"></div>
							<div class="p-2 bd-highlight">
								<label class="confirm-text-7 text-right">$ ${priceWithTaxes}</label>
							</div>
						</div>
					</div>

					<div class="row desk">
						<div class="col-md-1"></div>
						<div class="col-md-6">
							<label class="confirm-text-6 text-left">Total con
								impuestos incluidos</label>
						</div>
						<div class="col-md-2">
							<label class="confirm-text-7 text-right">$ ${priceWithTaxes}</label>
						</div>
						<div class="col-md-3"></div>
					</div>

				</div>


				<div class="row row-separation content-space">
					<div data-placement="right"
						class="tool icon-azul-bg-portabilidad-movistar">i</div>
					<label class="subtitle">Solo te cobraremos cuando se
						realice el cambio de operadora.</label>
				</div>

				<div class="row row-separation content-space">
					<button class="continue-button mobile" type="submit" name="submit">Confirmar</button>
				</div>

				<div class="row row-separation content-space">
					<label class="confirm-text-3">Al dar clic al botón
						"Confirmar", autorizo que Movistar me contacte telefónicamente o
						vía WhatsApp.</label>
				</div>


				<!-- BARRA INFERIOR  -->
				<div class="d-flex justify-content-between footer-container desk">
					<div>
						<a href="${actionCodeNIP}">
							<button class="cancel-btn-squater d-flex align-items-center">
								<span
									class="icon-icono-flecha-izquierda-small font-size-200 icon-azul-movistar"></span>
								Cancelar
							</button>
						</a>
					</div>
					<div>
						<div class="my-auto d-flex bullet">
							<div class="rounded-circle bg-white circle-size-selected"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
						</div>
					</div>
					<div>
						<button
							class="continue-btn-squater d-flex align-items-center justify-content-end"
							type="submit" name="submit">
							<span>Continuar</span> <span
								class="icon-gris-movistar-1 font-size-200 icon-icono-flecha-derecha-small"></span>
						</button>
					</div>
				</div>
				<!-- ////////////////////////////////////////// -->
			</form>
		</div>

	</div>
</div>
