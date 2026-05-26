// Page script for UserCard and Toggle
document.addEventListener('DOMContentLoaded', function () {
	const defaultUser = {
		name: 'John Doe',
		title: 'Architect & Engineer',
		location: 'New York, USA',
		email: 'john.doe@example.com',
		detailsVisible: false
	};

	// Try to load saved state from localStorage
	const saved = localStorage.getItem('userState');
	const userState = saved ? JSON.parse(saved) : defaultUser;

	const userCard = document.getElementById('userCard');
	const toggleBtn = document.getElementById('toggleBtn');

	function renderUserCard(state) {
		userCard.innerHTML = `
			<div class="container">
				<h4><b>${state.name}</b></h4>
				<p>${state.title}</p>
				${state.detailsVisible ? `
					<p><strong>Location:</strong> ${state.location}</p>
					<p><strong>Email:</strong> <a href="mailto:${state.email}">${state.email}</a></p>
				` : ''}
			</div>
		`;
	}

	// Initial render
	renderUserCard(userState);

	// Toggle handler updates JSON state, DOM, and saves to localStorage
	toggleBtn.addEventListener('click', function () {
		userState.detailsVisible = !userState.detailsVisible;
		renderUserCard(userState);
		localStorage.setItem('userState', JSON.stringify(userState));
	});

	// Expose for debugging
	window.__userState = userState;
});

console.log('script.js loaded');

